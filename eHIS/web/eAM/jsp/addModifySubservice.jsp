<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eAM/js/Subservice.js'  language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String servicecode="", service_short_desc="",subservicecode="",longdesc="",shortdesc="",eff_status="",sourceid="",s="",rdonly="",fnval="insert",def="checked";
		
		Connection conn = null;
		Statement stmt=null;
		PreparedStatement pstmt = null;
		ResultSet rset=null;

		try
		{	
			conn = ConnectionManager.getConnection(request);
			subservicecode=request.getParameter("subservice_code");
			servicecode=request.getParameter("service_code");
			sourceid = request.getParameter("source");

			stmt = conn.createStatement();
			if(subservicecode!=null && servicecode!=null)
			{
				
				//rset=stmt.executeQuery("select service_short_desc,subservice_code,subservice_long_desc,subservice_short_desc,eff_status from am_subservice_vw where subservice_code='"+subservicecode+"' and service_code='"+servicecode+"'");
				
				String sql = "select service_short_desc,subservice_code,subservice_long_desc,subservice_short_desc,eff_status from am_subservice_vw where subservice_code=? and service_code=?";
				
				pstmt   = conn.prepareStatement(sql);
				pstmt.setString	(	1,	subservicecode		);
				pstmt.setString	(	2,	servicecode		);

				rset		 = pstmt.executeQuery();
				if(rset != null &&  rset.next())
				{
					   rdonly="readonly";
					   fnval="modify";

					   service_short_desc=rset.getString("service_short_desc");
					   if(service_short_desc==null)service_short_desc="";

					   subservicecode = rset.getString("subservice_code");
					   

					   longdesc = rset.getString("subservice_long_desc");
					   if(longdesc==null)longdesc="";

					   shortdesc = rset.getString("subservice_short_desc");
					   if(shortdesc==null)shortdesc="";

					   eff_status=rset.getString("eff_status");
					   if(eff_status.equals("D"))
					   s="readonly";
				}
			}
			if(subservicecode==null)subservicecode="";
			if(rset !=null) rset.close();
		%>
	</head>
		<body   onLoad="FocusFirstElement();" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
			<form name='subservice_form' id='subservice_form' action='../../servlet/eAM.SubserviceServlet' method='post' target='messageFrame'>
				<div>
				<br><br><br><br><br><br><br><br>
				<table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
				<tr>
					<td width='10%'>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td width='10%'>&nbsp;</td>
				</tr>
				<tr>
					<%
					if(sourceid.equals("Insert"))
					{
						%>
					  <td>&nbsp;</td>
					  <td   class="label" ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
					  <td class='fields'>&nbsp;&nbsp; <select name="service_code" id="service_code" >
						  <OPTION VALUE=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----
							<%
							
							rset = stmt.executeQuery( "Select service_code,short_Desc from am_service where eff_status='E' order by 2");
							
								if( rset != null )
								{
									while( rset.next() )
									{
										String servicecode1 = rset.getString( "service_code" ) ;
										String servicedesc1 = rset.getString( "short_desc" ) ;
										if ( servicecode1.equals( servicecode ) )
											out.println( "<option value='" + servicecode1 + "' SELECTED > "+ servicedesc1);
										else
											out.println( "<option value='" + servicecode1 + "' >" + servicedesc1 ) ;
									}
								}
							
						}
						else
						{
							%>
							<td>&nbsp;</td>
							<td  class="label" ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
							<td class='fields'>&nbsp;
							<input type='hidden' name='service_code' id='service_code' value='<%=servicecode%>' >
							<input type='text' name='service_short_desc' id='service_short_desc' value='<%=service_short_desc%>' size='15'maxlength='15' readonly>
						<%}
					%>
				</select>
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td   class='label' ><fmt:message key="Common.subservice.label" bundle="${common_labels}"/><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
				<td   class='fields'>&nbsp;&nbsp;
				<input type='text' onKeyPress="return CheckForSpecChars(event)"  name='subservice_code' id='subservice_code' value='<%=subservicecode%>' size='4'maxlength='4' onBlur=ChangeUpperCase(this); <%=rdonly%> >&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img> </td>
			 <td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td>&nbsp;</td>
			<td   class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td   class='fields' >&nbsp;&nbsp;
					<input type='text' name='long_desc' id='long_desc' value="<%=longdesc%>" size='30' onBlur="makeValidString(this)" maxlength='30' style='{ font-size: ;}'  <%out.print(s);%>>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td>&nbsp;</td>
			<td   class='label' ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td  class='fields' >&nbsp;&nbsp;
				<input type='text' name='short_desc' id='short_desc' value="<%=shortdesc%>"  onBlur="makeValidString(this)"  size='15' maxlength='15' <%out.print(s);%>>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		<tr>
			<td>&nbsp;</td>
			<td   class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<%
					if(eff_status.equals("D"))
				   def="";
				%>
				 <input type='hidden' name='checked1' id='checked1'  value='<%=def%>'>
			 <td   class='fields'>&nbsp;&nbsp;<input type='checkbox' name='eff_status' id='eff_status'value='E'  <%=def%>>&nbsp;</td>
			 <td>&nbsp;</td>
				<%
					s="";
				%>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		</table>
	</div>
			<input type='hidden' name='function' id='function' value='<%=fnval%>'>
			<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
	<%
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		finally
		{	
			try
			{
			if(stmt!=null) stmt.close();
			if(rset!=null) rset.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			ConnectionManager.returnConnection(conn,request);
		}
	%>		
	</form>
</body>
</html>

