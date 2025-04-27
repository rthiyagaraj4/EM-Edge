<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eIP/js/DischargeStatus.js'></script>
                <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null;

	String discharge_status_code	= "";
	String long_desc			    = "";
	String short_desc				= "";
	String eff_status				= "";
	String readOnly					= "";
	String indicator				= "";
	String sel0						= "";
	String sel1						= "";
	String sel2						= "";
	String sel3						= "";
	String sel4						= "";
	String fn_val					= "insert";
	String other_read_only          = "";
	String dis						= "";
	String chk_val					= "";
	String other_disabled	="";
	try
		{
			con = ConnectionManager.getConnection(request);
			discharge_status_code=request.getParameter("discharge_status_code")==null?"":request.getParameter("discharge_status_code");
			if(!discharge_status_code.equals(""))
			{
				readOnly		    = "readonly";
				fn_val				= "modify";
				StringBuffer sql	= new StringBuffer();
				sql.append("select * from ip_discharge_status where discharge_status_code='"+discharge_status_code+"'");
				stmt				=	con.createStatement();
				rs					=	stmt.executeQuery(sql.toString());
				if(rs!=null)
				{
					if(rs.next())
					{
						long_desc	= rs.getString("long_desc")==null?"":rs.getString("long_desc");
						short_desc	= rs.getString("short_desc")==null?"":rs.getString("short_desc");
						indicator	= rs.getString("discharge_status_ind")==null?"":rs.getString("discharge_status_ind");
						if(indicator.equals("C"))
							sel0	= "selected";
						if(indicator.equals("P"))
							sel1	= "selected";
						if(indicator.equals("S"))
							sel2    = "selected";
						if(indicator.equals("W"))
							sel3	= "selected";
						if(indicator.equals("D"))
							sel4	= "selected";
						eff_status	= rs.getString("eff_status")==null?"":rs.getString("eff_status");

						if(eff_status.equals("D"))
						{
							other_read_only	= "readonly";
							dis				= "disabled";
							other_disabled = "disabled";
						}
						else
						other_disabled="";
					}
					if(rs != null ) rs.close(); 
				}
			}
			else
			{
				discharge_status_code	= "";
			}
%>

<body onLoad='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name='Discharge_Status_Form' id='Discharge_Status_Form' method='post' action='../../servlet/eIP.DischargeStatusServlet' target='messageFrame'>
		<table cellspacing=0 cellpadding=0 align='center' width='100%' height='100%'  border='0' >
			<tr>
				<td height='100%' width='100%' align='middle' class='white'>
					<table cellspacing=0 cellpadding=0 align='center' width='70%' border='0'>
						<tr>
							<td class='label' align='right'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
							<td>&nbsp;&nbsp;<input type='text' name='discharge_status_code' id='discharge_status_code' size='2' maxlength='2' value="<%=discharge_status_code%>" onBlur='ChangeUpperCase(this)' <%=readOnly%> onKeyPress="return CheckForSpecChars(event)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
						</tr>
						<tr>
							<td colspan='2'>&nbsp</td>
						</tr>
						<tr>
							<td class='label' align='right'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
							<td>&nbsp;&nbsp;<input type='text' name='long_desc' id='long_desc' size=30 maxlength=30 value="<%=long_desc%>" <%=other_read_only%> onBlur="return makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
						</tr>	
						<tr>
							<td colspan='2'>&nbsp</td>
						</tr>
						<tr>
							<td class='label' align='right'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
							<td>&nbsp;&nbsp;<input type='text' name='short_desc' id='short_desc' size=15 maxlength=15 value="<%=short_desc%>" <%=other_read_only%> onBlur="return makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
						</tr>	
						<tr>
							<td colspan='2'>&nbsp</td>
						</tr>
						<tr>
							<td class='label' align='right'><fmt:message key="eIP.DischargeStatusIndicator.label" bundle="${ip_labels}"/></td>
							<td>&nbsp;&nbsp;<select name="block_indicate" id="block_indicate" <%=other_disabled%> >
								<option value="">---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
								<option value = 'C'<%=sel0%>><fmt:message key="eIP.CompleteRecovery.label" bundle="${ip_labels}"/></option>
								<option value = 'P'<%=sel1%>><fmt:message key="eIP.PartialRecovery.label" bundle="${ip_labels}"/></option>
								<option value = 'S'<%=sel2%>><fmt:message key="eIP.StatusQuo.label" bundle="${ip_labels}"/></option>
								<option value = 'W'<%=sel3%>><fmt:message key="eIP.ConditionWorse.label" bundle="${ip_labels}"/></option>
								<option value = 'D'<%=sel4%>><fmt:message key="Common.deceased.label" bundle="${common_labels}"/></option>
								</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
							</td>
						</tr>
						<tr>
							<td colspan='2'>&nbsp</td>
						</tr>
						<tr>
							<td class='label' align='right'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
							<%
								chk_val="checked";
								if(eff_status.equals("D"))
									chk_val="";
							%>
							<td>&nbsp;<input type='checkbox' name='eff_status' id='eff_status' value='E' <%=chk_val%>></td>
						</tr>
						<tr>
							<td colspan='2'>&nbsp</td>
						</tr>
					</table>
				</td>
			</tr>
		<table>
		<input type='hidden' name='function_name' id='function_name' value="<%=fn_val%>">
		<input type='hidden' name='hid_block_indicate' id='hid_block_indicate' value="<%=indicator%>">
	</form>
</body>
</html>
<%
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
	}catch(Exception e) {out.println(e.toString());}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

