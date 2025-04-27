<!DOCTYPE html>
<!--
	Developed by :	Chitra 
	Created on 	 :	21/06/2001
	Module		 :	IP
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script language='javascript' src='../js/DischargeType.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<script>
</script>
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
			String discharge_type_code	= "";
//			String indicate	="";
			String long_desc			= "";
			String short_desc			= "";
			String deceased_yn			= "";
			String maternal_death_yn	= "";
			String eff_status			= "";
			String readOnly				= "";
			String other_read_only		= "";
			String fn_val				= "insert";
			String dis					= "";
			String chk					= "";
//			String Dis					= "disabled";
			String maternal_death_value		= "";
			String blocking_type="";
			String indicator			="";
			String sel0="";String sel1="";String sel2="";String sel3="";
			String sel5="";
		try
		{
			con = ConnectionManager.getConnection(request);
			discharge_type_code=request.getParameter("discharge_type_code")==null?"":request.getParameter("discharge_type_code");

//			indicate=request.getParameter("dead")==null?"":request.getParameter("dead");

			if(!discharge_type_code.equals(""))
			{
				readOnly	= "readonly";
				fn_val		= "modify";
				StringBuffer sql = new StringBuffer();
				sql.append("select * from ip_discharge_type where discharge_type_code='"+discharge_type_code+"'");
				stmt			=	con.createStatement();
				rs				=	stmt.executeQuery(sql.toString());
				if(rs!=null)
				{
					if(rs.next())
					{
						long_desc	= rs.getString("long_desc")==null?"":rs.getString("long_desc");
						short_desc	= rs.getString("short_desc")==null?"":rs.getString("short_desc");
						indicator	= rs.getString("INDICATOR")==null?"":rs.getString("INDICATOR");
						if(indicator.equals("ND"))
							sel0="selected";
						if(indicator.equals("ED"))
							sel1="selected";
						if(indicator.equals("AB"))
							sel2="selected";
						if(indicator.equals("AO"))
							sel3="selected";
						if(indicator.equals("DS"))
							sel5="selected";
						
						maternal_death_yn	= rs.getString("MATERNAL_DEATH_YN")==null?"":rs.getString("MATERNAL_DEATH_YN");
						blocking_type=rs.getString("blocking_type_code");
						if(blocking_type==null)blocking_type="";
						eff_status	= rs.getString("eff_status")==null?"":rs.getString("eff_status");

						if(eff_status.equals("D"))
						{
							other_read_only	= "readonly";
							dis				= "disabled";
						}
					}
					if(rs != null ) rs.close(); if(stmt != null) stmt.close();
				}
			}
			else
			{
				discharge_type_code	= "";
			}
	%>

	</head>

<body onLoad='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name='Discharge_Type_Form' id='Discharge_Type_Form' method='post' action='../../servlet/eIP.DischargeTypeServlet' target='messageFrame'>


		<table cellspacing=0 cellpadding=0 align='center' width='100%' height='100%'  border='0' >
			<tr>
				<td height='100%' width='100%' align='middle' class='white' width='100%'>
					<table cellspacing=0 cellpadding=0 align='center' width='70%' border='0'>
						<tr><td colspan='2'>&nbsp</td></tr>
						<tr>
							<td class='label' align='right'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
							<td>&nbsp;&nbsp;<input type='text' name='discharge_type_code' id='discharge_type_code' size='2' maxlength='2' value="<%=discharge_type_code%>" onBlur='ChangeUpperCase(this)' <%=readOnly%> onKeyPress="return CheckForSpecChars(event)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
						</tr>	
						<tr><td colspan='2'>&nbsp</td></tr>
						<tr>
							<td class='label' align='right'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
							<td>&nbsp;&nbsp;<input type='text' name='long_desc' id='long_desc' size=30 maxlength=30 value="<%=long_desc%>" <%=other_read_only%> onBlur="return makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
						</tr>	
						<tr><td colspan='2'>&nbsp</td></tr>
					
						<tr>
							<td class='label' align='right'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
							<td>&nbsp;&nbsp;<input type='text' name='short_desc' id='short_desc' size=15 maxlength=15 value="<%=short_desc%>" <%=other_read_only%> onBlur="return makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
						</tr>	
						<tr><td colspan='2'>&nbsp</td></tr>
						<tr>
							<td class='label' align='right'><fmt:message key="eIP.BlockingType.label" bundle="${ip_labels}"/></td>
							<td>&nbsp;&nbsp;<select name="blocking_type" id="blocking_type" <%=dis%>>
				<option value="">---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---<%
					stmt = con.createStatement();
					rs = stmt.executeQuery("select blocking_type_code,short_desc from ip_blocking_type where eff_status = 'E' order by short_desc");
					if(rs != null)
					{
						while(rs.next())
						{
							String desc = rs.getString("short_desc")== null ? "" : rs.getString("short_desc");
							String code = rs.getString("blocking_type_code")==null ? "":rs.getString("blocking_type_code");
							String sel = "";
								if (code.equals(blocking_type))
									sel = "selected";
								else
									sel = "";
								
								out.print("<option value='"+code+"'"+sel+">"+desc );
						}
					}
					if(rs != null ) rs.close(); if(stmt != null) stmt.close();
				%>
			</select>
					<input type='hidden' name='hid_blocking_type' id='hid_blocking_type' value="<%=blocking_type%>">
			</td>
				</tr>
					<tr><td colspan='2'>&nbsp</td></tr>
					<tr>
					<td class='label' align='right'><fmt:message key="eIP.DischargeTypeIndicator.label" bundle="${ip_labels}"/></td>
					<td>&nbsp;&nbsp;<select name="block_indicate" id="block_indicate" <%=dis%> onChange ="setIndicator(this);">
					<option value="">---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
					<option value = 'AB' <%=sel2%>><fmt:message key="eIP.Absconded.label" bundle="${ip_labels}"/></option>
					<option value = 'AO' <%=sel3%>><fmt:message key="Common.AtOwnRisk.label" bundle="${common_labels}"/></option>
					<option value = 'DS' <%=sel5%>><fmt:message key="Common.deceased.label" bundle="${common_labels}"/></option>
					<option value = 'ND' <%=sel0%>><fmt:message key="eIP.DischargedHome.label" bundle="${ip_labels}"/></option>
					<option value = 'ED' <%=sel1%>><fmt:message key="Common.TransfertoOtherHospital.label" bundle="${common_labels}"/></option>
					</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
					<input type='hidden' name='hid_block_indicate' id='hid_block_indicate' value="<%=indicator%>">
					<input type='hidden' name='deceased_yn' id='deceased_yn' value="">
					</td>
				</tr>
				<tr><td colspan='2'>&nbsp</td></tr>
								<%
								String chk_val="";
								%>
						<%--<tr>
							<td class='label' align='right'><fmt:message key="Common.deceased.label" bundle="${common_labels}"/></td>
							<%
								String chk_val="";
								String Disabled="";
								if(deceased_yn.equals("Y"))
									chk_val="checked";
								if(eff_status.equals("E"))
									Disabled="";
							%>
							<td>&nbsp;<input type='checkbox' name='deceased_yn' id='deceased_yn' value='Y' <%=chk_val%> <%=Disabled%> <%=dis%> onclick="callChk(this,'<%=eff_status%>');enabledeath(this)"></td>
						</tr>--%>	
						<!-- Added by Sridhar R on 29 JULY 2004  -->
							<tr>
							<td class='label' align='right'><fmt:message key="eIP.MaternalDeath.label" bundle="${ip_labels}"/></td>
							<%	
								if(maternal_death_yn.equals("Y"))
								{	
									chk="checked";
									maternal_death_value = "Y";
								}
								else
								{
									chk="";
									maternal_death_value = "N";
								}
							  /*
								if(dis.equals(""))
									Dis = "";
								else
									Dis = "disabled";
							  */

							%>
							
							<td>&nbsp;<input type='checkbox' name='maternal_death' id='maternal_death' value='<%=maternal_death_value%>' <%=dis%> <%=chk%> onclick="callChk(this,'<%=eff_status%>');valuate(this)" ></td>
						</tr>	
						<tr><td colspan='2'>&nbsp</td></tr>
						<tr>
							<td class='label' align='right'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
							<%
								chk_val="checked";
								if(eff_status.equals("D"))
									chk_val="";
							%>
							<td>&nbsp;<input type='checkbox' name='eff_status' id='eff_status' value='E' <%=chk_val%>></td>
						</tr>	
						<tr><td colspan='2'>&nbsp</td></tr>
					</table>
				</td>
			</tr>
		</table>
		<input type='hidden' name='function_name' id='function_name' value="<%=fn_val%>">
		 <input type='hidden' name='deceased_yn_hid' id='deceased_yn_hid' value="<%=deceased_yn%>"> 
		<input type='hidden' name='maternal_death_yn_hid' id='maternal_death_yn_hid' value="<%=maternal_death_yn%>">

							
							
<%	

if(fn_val.equals("modify"))
{
	if(indicator.equals("DS") && eff_status.equals("E"))
	{
		out.println("<script>document.forms[0].maternal_death.disabled=false;</script>");
		if(maternal_death_yn.equals("Y"))
			out.println("<script>document.forms[0].maternal_death.checked=true;</script>");
		else
			out.println("<script>document.forms[0].maternal_death.checked=false;</script>");
	}
	else if(!indicator.equals("DS"))
	{
		out.println("<script>document.forms[0].maternal_death.disabled=true;</script>");
		out.println("<script>document.forms[0].maternal_death.checked=false;</script>");
		out.println("<script>document.forms[0].maternal_death.value='N';</script>");
	}
}	
%>
	
	
	
	</form>

</body>
</html>
<%
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
	}catch(Exception e) {//out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>

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

