<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		

		<script language='javascript' src='../js/BlockingType.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<%
			Connection con = null;
			Statement stmt = null;
			PreparedStatement  pstmt = null;
			ResultSet rs =null;
			String block_type_code="";
			String long_desc="";
			String short_desc="";
			String bed_block_period_max1="";
			String bed_block_period_max_type1="";
			String override="";
			String eff_status="";
			String readOnly="";
			String other_read_only="";
			String fn_val="insert";
			String dis="";
		try{
			con =ConnectionManager.getConnection(request);
			block_type_code=request.getParameter("block_type_code");
			if(block_type_code!=null)
			{
				readOnly="readonly";
				fn_val="modify";
				StringBuffer sql = new StringBuffer();
				sql.append("select * from ip_blocking_type where blocking_type_code=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, block_type_code);
				
/* 				stmt	=	con.createStatement(); */
				rs		=	pstmt.executeQuery();
				if(rs!=null)
				{
					if(rs.next())
					{
						long_desc	=	rs.getString("long_desc");
						short_desc	=	rs.getString("short_desc");
						override	=	rs.getString("override_yn");
						eff_status	=	rs.getString("eff_status");
						bed_block_period_max1=rs.getString("DFLT_MIN_BLOCK_PERIOD")==null?"":rs.getString("DFLT_MIN_BLOCK_PERIOD");
						bed_block_period_max_type1=rs.getString("DFLT_BLOCK_UNITS")==null?"":rs.getString("DFLT_BLOCK_UNITS"); 

						if(eff_status.equals("D"))
						{
							dis="disabled";
						}
			
						if(eff_status.equals("D"))
						other_read_only="readonly";
					}
				}
			}
			else
			{
				block_type_code="";
			}

		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
	}catch(Exception e) {
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
		%>
		<script>
		function callChk()
		{
			if("<%=other_read_only%>" =="readonly")
			{
				if("<%=override%>"=="Y")
				{
					document.Blocking_Type_Form.override.checked=true;
				}
				else
					document.Blocking_Type_Form.override.checked=false;
			}
		}
		</script>
	</head>

	<body onLoad='focusTxt()'; onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='Blocking_Type_Form' id='Blocking_Type_Form' method='post' action='../../servlet/eIP.BlockingTypeServlet' target='messageFrame'>
			<table cellspacing=0 cellpadding=0 align='center' width='85%' height='100%'  border='0'>
				<tr>
					<td height='100%' width='70%' align='middle' class='white'>
						<table cellspacing=0 cellpadding=0 align='center' width='85%' border='0'>

							<tr><td colspan='2'>&nbsp</td></tr>

							<tr>
								<td class='label' align='left'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
								<td>&nbsp;&nbsp;<input type='text' name='blocking_type_code' id='blocking_type_code' size='2' maxlength='2' value="<%=block_type_code%>" onBlur='ChangeUpperCase(this)' <%=readOnly%> onKeyPress="return CheckForSpecChars(event)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
							</tr>	

							<tr><td colspan='2'>&nbsp</td></tr>

							<tr>
								<td class='label' align='left' nowrap><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
								<td>&nbsp;&nbsp;<input type='text' name='long_desc' id='long_desc' size=30 maxlength=30 value="<%=long_desc%>" <%=other_read_only%> onBlur="makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
							</tr>	

							<tr><td colspan='2'>&nbsp</td></tr>

							<tr>
								<td class='label' align='left'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
								<td>&nbsp;&nbsp;<input type='text' name='short_desc' id='short_desc' size=15 maxlength=15 value="<%=short_desc%>" <%=other_read_only%> onBlur="makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
							</tr>

							<tr><td colspan='2'>&nbsp</td></tr>
							<tr>
							<td class='label' align='left'><fmt:message key="eIP.BlockingPeriod.label" bundle="${ip_labels}"/></td>
							
							<td>&nbsp;&nbsp;<input type='text'align="left"  name='bed_block_period_max' id='bed_block_period_max'  size='3' maxlength='3' value="<%=bed_block_period_max1%>" <%=other_read_only%> onKeyPress='return Validate_Char(event)' onBlur='CheckZeroVal(this);'>&nbsp;<select name="bed_block_period_max_type" id="bed_block_period_max_type" <%=dis%>>
						<%if(bed_block_period_max_type1==""||bed_block_period_max_type1=="H")
						{%>
							<option value='H' Selected><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
							<option value='D' ><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
						<%}else{%>
					     	<option value='H' ><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
							<option value='D' Selected><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
						
						<%}%>
							</select>&nbsp;
							</td>
							</tr>

						<%
						if(bed_block_period_max_type1.equalsIgnoreCase("H")){%>
							<script>
								document.getElementById("bed_block_period_max_type").options[0].selected=true;
							</script>
					<%	}else{  %>
							<script>
								document.getElementById("bed_block_period_max_type").options[1].selected=true;
							</script>
						<%	}  %>
							<tr><td colspan='2'>&nbsp</td></tr>

							<tr>
								<td class='label' align='left'><fmt:message key="Common.override.label" bundle="${common_labels}"/></td>
								<%
									String chk_val="";
										if(override.equals("Y"))
											chk_val="checked";
								%>
								<td>&nbsp;<input type='checkbox' name='override' id='override' value='Y' <%=chk_val%> onclick='callChk(this,"<%=eff_status%>")'></td>
							</tr>	

							<tr><td colspan='2'>&nbsp</td></tr>

							<tr>
								<td class='label' align='left'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
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
		</form>
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

