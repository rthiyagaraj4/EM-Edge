<!DOCTYPE html>
<%--
	FileName	: AddModifySection.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page  contentType="text/html;charset=UTF-8" import= "java.util.*,java.sql.*,java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>
<script language='javascript' src='../../eAM/js/Section.js'></script>

<html>	

	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement();' onKeyDown = 'lockKey()'>
		<form name='section_form' id='section_form' action='../../servlet/eAM.SectionServlet' method='post' target='messageFrame'> 
		<div><br><br><br><br><br><br><br><br>
		<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
		
		<tr class="label">
			<td width='10%' class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
			<td width='10%' class="label">&nbsp;</td>
		</tr>
		
		<tr>
			<td class="label">&nbsp;</td>
			<td class='label'><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/></td>
			<td class="fields">
		<% 
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String section_code 	= request.getParameter("section_code");
		String dept_code	= request.getParameter("dept_code");

		Connection conn 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try
		{
			conn = ConnectionManager.getConnection(request);
		
		if (section_code == null && dept_code == null)
		{
			%>
			<select name='dept_code' id='dept_code' ><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<%
			pstmt 	= conn.prepareStatement( "select dept_code,short_desc from am_dept where eff_status='E' order by short_desc" ) ;
			rs = pstmt.executeQuery() ;

			if( rs != null ) 
			{
				while( rs.next() ) 
				{
					String Value 	= rs.getString( "dept_code" ) ;
					String Label 	= rs.getString( "short_desc" ) ;
					out.println( "<option value='" + Value + "' >" + Label ) ;
				}
			}
		%>
			</select> 
			<img src='../../eCommon/images/mandatory.gif'align='center'></img>
			</td><td class="label">&nbsp;</td>
		</tr>		
	
		<tr class="label">
			<td colspan='4' class="label">&nbsp;</td>
		</tr>
		
		<tr>
			<td class="label">&nbsp;</td>
			<td class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td class="fields">
			<input type='text' onKeyPress='return CheckForSpecChars(event)'  name='section_code' id='section_code' size='7' maxlength='6' onBlur='ChangeUpperCase(this)'>
			<img src='../../eCommon/images/mandatory.gif'align='center'></img>
			</td><td class="label">&nbsp;</td>
		</tr>
		<tr class="label">  
			<td class="label" colspan='4'>&nbsp;</td>
		</tr>
		<tr>
			<td class="label">&nbsp;</td>
			<td class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td class="fields">
			<input type='text' name='long_desc' id='long_desc' size='30' onBlur='makeValidString(this)' maxlength='30' style='{ font-size: ;}'>
			<img src='../../eCommon/images/mandatory.gif'align='center'></img>
			</td><td class="label">&nbsp;</td>
		</tr>
		<tr class="label">
			<td class="label" >&nbsp;</td>
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
		</tr>
		<tr>
			<td class="label">&nbsp;</td>
			<td class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td class="fields">
			<input type='text' name='short_desc' id='short_desc' onBlur='makeValidString(this)' size='15' maxlength='15'>
			<img src='../../eCommon/images/mandatory.gif'align='center'></img>
			</td><td class="label">&nbsp;</td>
		</tr>
		<tr class="label">
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
		</tr>
		<tr>
			<td class="label">&nbsp;</td>
			<td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td class='fields'>
			<input type='checkbox' name='eff_status' id='eff_status' value='E' checked onClick='Change()'>&nbsp;</td>
			<td class="label">&nbsp;</td>
		</tr>
		<tr class="label">
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
		</tr>
			</table></div>
			<input type='hidden' name='function' id='function' value='insert'>
			<input type='hidden' name='eff_date_from' id='eff_date_from' >
			<input type='hidden' name='eff_date_to' id='eff_date_to' >
			<input type='hidden' name='function_name' id='function_name' value='insert'>
				<%
		}
		else
		{
				//stmt = conn.createStatement();
				String sql = "select dept_code,dept_short_desc,section_code,section_long_desc,section_short_desc,eff_status from am_dept_section_vw where dept_code=? and section_code=?";
				//rset = stmt.executeQuery(sql);
				
				pstmt   = conn.prepareStatement(sql);
				pstmt.setString	(	1,	dept_code		);
				pstmt.setString	(	2,	section_code		);

				rset		 = pstmt.executeQuery();
					
				rset.next();
				%>
				<input type='hidden' name='dept_code' id='dept_code' value='<%=rset.getString("dept_code")%>' size='10' maxlength='10'>
				<input type='text' name='dept_desc' id='dept_desc' value='<%=rset.getString("dept_short_desc")%>' size='15' maxlength='15' readonly onBlur='makeValidString(this)' >
				<img src='../../eCommon/images/mandatory.gif'></img>
				<td class="label">&nbsp;</td>
				<tr class="label">
					<td class="label">&nbsp;</td>
					<td class="label">&nbsp;</td>
					<td class="label">&nbsp;</td>
					<td class="label">&nbsp;</td>
				</tr>
				<tr>
					<td class="label">&nbsp;</td>
					<td class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td> 
					<td class="fields">
					<input type='text' name='section_code' id='section_code'  onBlur='makeValidString(this)' value='<%=rset.getString("section_code")%>' size='7' maxlength='6' readonly >
					<img src='../../eCommon/images/mandatory.gif'></img>  </td>
					<td class="label">&nbsp;</td>
				</tr>
				<%
				if ( rset.getString("eff_status").equals("E") )
				{
				%>
						
					<tr class="label">
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
					</tr>
					<tr>
						<td class="label">&nbsp;</td>
						<td class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
						<td class="fields">
						<input type='text' name='long_desc' id='long_desc' onBlur='makeValidString(this)' size='30' maxlength='30' value="<%=rset.getString("section_long_desc")%>">
						<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
						<td class="label">&nbsp;</td>
					</tr>
					<tr class="label">
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
					</tr>
					<tr>
						<td class="label">&nbsp;</td>
						<td class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
						<td class="fields"><input type='text' name='short_desc' id='short_desc' size='15' onBlur='makeValidString(this)' maxlength='15' value="<%=rset.getString("section_short_desc")%>">
						<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
						<td class="label">&nbsp;</td>
					</tr>
					<TR class="label">
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
					</TR>
					<tr>
						<td class="label">&nbsp;</td>
						<td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
						<td class='fields'>
							<input type='checkbox' name='eff_status' id='eff_status' value='E' checked onClick='Change()'></td>
						<td class="label">&nbsp;</td>
					</tr>
					<TR class="label">
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
					</TR> 
				</table>
				</div>
				<input type='hidden' name='function' id='function' value='modify'>
				<input type='hidden' name='eff_date_from' id='eff_date_from'>
				<input type='hidden' name='eff_date_to' id='eff_date_to'>
				<input type='hidden' name='function_name' id='function_name' value='modify'>
			</form>
								
			<%
				}
				if ( rset.getString("eff_status").equals("D") )
				{
					%>
					<tr class="label">
					   <td class="label">&nbsp;</td>
					   <td class="label">&nbsp;</td>
					   <td class="label">&nbsp;</td>
					   <td class="label">&nbsp;</td>
					</TR>
					<tr>
						<td class="label">&nbsp;</td>
						<td class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
						<td class="fields"><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value='<%=rset.getString("section_long_desc")%>'readonly>
						<img src='../../eCommon/images/mandatory.gif'></img></td>
						<td class="label">&nbsp;</td>
					</tr>
					<TR class="label">
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
					</TR>
					<tr>
						<td class="label">&nbsp;</td>
						<td class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
						<td class="fields"><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' value='<%=rset.getString("section_short_desc")%>' readonly onBlur='makeValidString(this)' >
						<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
						<td class="label">&nbsp;</td>
					</tr>
					<TR class="label">
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
					</TR>
					<tr>
						<td class="label">&nbsp;</td>
						<td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
						<td class='fields'><input type='checkbox' name='eff_status' id='eff_status' value='D' onClick='Change()'></td>
						<td class="label">&nbsp;</td>
					</tr>
					<TR class="label">
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
						<td class="label">&nbsp;</td>
					</TR>
				</table>
			</div>
				<input type='hidden' name='function' id='function' value='modify'>
				<input type='hidden' name='eff_date_from' id='eff_date_from'>
				<input type='hidden' name='eff_date_to' id='eff_date_to'>
				<input type='hidden' name='function_name' id='function_name' value='modify'>
			<%				
				}
			}
			  if (rs   != null) rs.close();
			  if (stmt != null) stmt.close();
			  if (rset != null) rset.close();
			  if (pstmt	!= null) pstmt.close();
		}	
			catch ( Exception e )
			{
				e.printStackTrace();
			}
			finally 
			{
			   ConnectionManager.returnConnection(conn,request);
			}
		%>
		</form>
	</body>
</html>

