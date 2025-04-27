<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>


<%@ include file="../../eCommon/jsp/Common.jsp" %> 

<% 
	request.setCharacterEncoding("UTF-8");
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
    PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	ResultSet rs3=null;
	Connection conn =null;

try {
	String mode = request.getParameter("mode");
    String position_code = "";
	String position_desc = "";
	String role_type= "";
	String staff_type="";
	String grade_code="";
	String grade_short_desc="";
	String position_expl_text="";
	String eff_status = "";
	String operation_type = "";
	//String serviceval = "";
	//String sel = "";
		
	conn = ConnectionManager.getConnection(request);
	ArrayList staff_list = new ArrayList();
	ArrayList grade_list = new ArrayList();
	

	
	if(mode.equals("2"))
	{
	
		
		position_code=request.getParameter("position_code");
		position_desc=request.getParameter("position_desc");
		role_type=checkForNull(request.getParameter("role_type"));
		staff_type=checkForNull(request.getParameter("staff_type"));
		eff_status=checkForNull(request.getParameter("eff_status"));
		grade_short_desc=checkForNull(request.getParameter("grade_short_desc"));
		grade_code=checkForNull(request.getParameter("grade_code"));

			
try
	{
		String sql="select position_expl_text from am_position where position_code=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString	( 1, position_code ) ;
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			position_expl_text=rs.getString("position_expl_text")==null ? "":rs.getString("position_expl_text");
		
				
		}
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();
	}
	catch(Exception e)
{
	e.printStackTrace();
}
			
		if(role_type.equals("P"))
		{
			
			String sql1="select pract_type,desc_userdef from am_pract_type where eff_status = 'E' order by desc_userdef ";
		
		stmt=conn.createStatement();
		rs1=stmt.executeQuery(sql1);
		while(rs1.next())
		{	
			staff_list.add(rs1.getString("pract_type"));
			staff_list.add(rs1.getString("desc_userdef"));
		}
			
		}
		else
		{
			
		String sql1="select other_staff_type,short_desc from am_other_staff_type where eff_status = 'E' order by short_desc";
		
		stmt=conn.createStatement();
		rs1=stmt.executeQuery(sql1);
		while(rs1.next())
		{	
			staff_list.add(rs1.getString("other_staff_type"));
			staff_list.add(rs1.getString("short_desc"));
		}	
		}

		String sql3="SELECT grade_code ,short_desc FROM am_grade WHERE eff_status = 'E' ORDER BY short_desc";
		
		stmt=conn.createStatement();
		rs3=stmt.executeQuery(sql3);
		while(rs3.next())
		{	
			grade_list.add(rs3.getString("grade_code"));
			grade_list.add(rs3.getString("short_desc"));
		}	
		if (rs3 != null)   rs3.close();
		if (rs1 != null)   rs1.close();
		if (stmt != null) stmt.close();
	}
%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eRS/js/RSMessages.js"></script>
	<script language="javascript" src="../js/Position.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function checkfld(position_expl_text)
	{
		
		if((position_expl_text.value.length) >4000)
		{
			alert(getMessage("AM0163","AM"));
		}
	}			

var sStyle="<%=sStyle%>";

	  function ChangeType(form,target)
	  {
       	 var role_type=target.value;		
			 removeitems(form.staff_type);

			 if(role_type=="")		
				document.forms[0].role_type.value='';					
			else{					
					var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'>";
					HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../eAM/jsp/FetchValueForRoleType.jsp'>";
					HTMLVal = HTMLVal +"<input name='role_type' id='role_type' type='hidden' value= '"+role_type +"'>";
					HTMLVal = HTMLVal +"</form></BODY></HTML>";
				parent.messageFrame.document.write(HTMLVal);
				parent.messageFrame.document.forms[0].submit();
			}
					
				
		}
		function removeitems(obj)
			{			
				var len=obj.length;
				var i=1;
				while(i<len)
				{
					len=obj.length
					obj.remove(i)
				}
			}
		</script>
	
</head>
<style>
textarea {
    resize: none;
}
</style>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<br><br>
<form name='form_AddModifyPosition' id='form_AddModifyPosition' 
action='../../servlet/eAM.PositionServlet' method='POST'
target='messageFrame'>
<table cellpadding=0 cellspacing=0 border=0 width="98%" align='center'>
<%
	if(mode.equals("1"))
	{
		operation_type="insert";
		%>
		<tr>
                   <td class="label">&nbsp;</td>
                   <td class="label">&nbsp;</td>
                   </tr>	
		<tr>
		<td  width="35%"  class="label"><fmt:message key="Common.Position.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;<input type=text name="position_code" id="position_code" value="" size='20' maxlength='10' onKeyPress="return CheckForSpecChars(event)" OnBlur='ChangeUpperCase(this)'><img src="../../eCommon/images/mandatory.gif"></td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr>
		<td  width="35%"   class="label"><fmt:message key="Common.Position.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type=text name="position_desc" id="position_desc" value="" size='30' maxlength='30' ><img src="../../eCommon/images/mandatory.gif"></td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr>
		<td  width="35%"   class="label"><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></td>
		<td>
			&nbsp;<select name='role_type' id='role_type' onChange='ChangeType(this.form,this)'>
				<option value=''>--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
				<option value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
				<option value='O'><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></option>
			</select>
		<img src="../../eCommon/images/mandatory.gif"></td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr>
		<td width="35%"  class="label"><fmt:message key="Common.StaffType.label" bundle="${common_labels}"/></td>
		<td>
			&nbsp;<select name="staff_type" id="staff_type">
			<option value=''>----------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------------------------------</option>
		</td>
	</tr>
		<tr><td colspan="2">&nbsp;</td></tr>
	 <tr>
	<td height='35%'  class='label'><fmt:message key="Common.Grade.label" bundle="${common_labels}"/></td>
	<td>&nbsp;<select name="grade_code" id="grade_code" >
			<option value=''>&nbsp;---------- ---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------- ----------&nbsp;
			<%
				
			String sql2="SELECT grade_code ,short_desc FROM am_grade WHERE eff_status = 'E' ORDER BY short_desc";
			stmt=conn.createStatement();
				rs2=stmt.executeQuery(sql2);
				while(rs2.next())
				 {					
					out.println("<option value='"+rs2.getString("grade_code")+"' >"+rs2.getString("short_desc")+"");
				 }
                 if(rs2!=null) 	rs2.close();
	             if(stmt!=null) 	stmt.close();
			%>
		</select>
        <input type='hidden' name='grade' id='grade' value="">
		
	</td>  
</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr>
		<td width="35%" class="label"><fmt:message key="Common.ExplanatoryText.label" bundle="${common_labels}"/></td>
		<td>
			&nbsp;<textarea name="position_expl_text"  rows='10' cols='50' maxlength='4000' onblur="checkfld(this)"></textarea>
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr>
		<td width="35%"  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td><input type=checkbox name="eff_status" id="eff_status" checked value='E' onclick="checkActive(this)">
		</td>
	</tr>
<tr>
   <td class="label">&nbsp;</td>
   <td class="label">&nbsp;</td>
   </tr>	

	
	</table>
   <% }else
			{
				operation_type = "modify";
				
				
	   %>
		   <table cellpadding=0 cellspacing=0 border=0 width="98%" align='center'>

<tr>
<td class="label">&nbsp;</td>
<td class="label">&nbsp;</td>
</tr>	
			<tr>
				<td  width="35%"   class="label"><fmt:message key="Common.Position.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type=text name="position_code" id="position_code" value="<%=position_code%>" size='20' maxlength='10' onKeyPress="return CheckForSpecChars(event)" readonly><img src="../../eCommon/images/mandatory.gif"></td>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			
			<%if(eff_status.equalsIgnoreCase("E"))
				{%>
			<tr>
				<td  width="35%"  class="label"><fmt:message key="Common.Position.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
				<td><input type=text name="position_desc" id="position_desc" value="<%=position_desc%>" size="32" maxlength="30" ><img src="../../eCommon/images/mandatory.gif"></td>
			<%}
				else
				{%>
					<td  width="35%"   class="label"><fmt:message key="Common.Position.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
					<td><input type=text name="position_desc" id="position_desc" value="<%=position_desc%>" size="32" maxlength="30"  readonly><img src="../../eCommon/images/mandatory.gif"></td>
						<%}%>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			
			<%if(eff_status.equalsIgnoreCase("E"))
				{%>
			<tr>
				<td  width="35%"   class="label"><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></td>
				<td> <select name='role_type' id='role_type'  onChange='ChangeType(this.form,this)' >
						<option value=''>--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
						<option value='P' <%=role_type.equals("P")?"selected":""%>><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
						<option value='O' <%=role_type.equals("O")?"selected":""%>><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></option>
					</select>
					<img src="../../eCommon/images/mandatory.gif"></td> 
			<%}
				else
				{%>
					<td  width="35%"   class="label"><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></td>
				<td>
					<select name='role_type' id='role_type' onChange='ChangeType(this.form,this)' disabled>
						<option value=''>--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
						<option value='P' <%=role_type.equals("P")?"selected":""%>><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
						<option value='O' <%=role_type.equals("O")?"selected":""%>><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></option>					</select>
					<img src="../../eCommon/images/mandatory.gif"></td>
			<%}%>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			
			<%if(eff_status.equalsIgnoreCase("E"))
				{%>
			<tr>
				<td width="35%" class="label"><fmt:message key="Common.StaffType.label" bundle="${common_labels}"/></td>
				<td>
				<select name="staff_type" id="staff_type">
					<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
				<%
				for(int i=0;i<staff_list.size();i+=2)
				{
				%>
			<option value='<%=staff_list.get(i)%>'  <%=staff_type.equals(staff_list.get(i))?"selected":""%>><%= (String)staff_list.get(i+1)%> </option>
				<%
				}
				%>
				</select>
				</td>
			<%}
				else
				{%>
					<td width="35%" class="label"><fmt:message key="Common.StaffType.label" bundle="${common_labels}"/></td>
				<td>
				<select name="staff_type" id="staff_type" disabled>
					<option value=''> --- --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- --- </option>
				<%
				for(int i=0;i<staff_list.size();i+=2)
				{
				%>
			<option value='<%= staff_list.get(i) %>' <%=staff_type.equals(staff_list.get(i))?"selected":""%>  ><%= (String)staff_list.get(i+1)%> </option>
				<%
				}
				%>

				</select>
				</td>
				<%}%>
			</tr>




			<tr><td colspan="2">&nbsp;</td></tr>
			
			<%
			String disable_chk="disabled";
			if(eff_status.equalsIgnoreCase("E"))
						disable_chk="";			
			%>
			<tr>
				<td width="35%"  class="label"><fmt:message key="Common.Grade.label" bundle="${common_labels}"/></td>
				<td>
				<select name="grade_code" id="grade_code" <%=disable_chk%> >
					<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
				<%
				for(int i=0;i<grade_list.size();i+=2)
				{
				%>
			<option value='<%=grade_list.get(i)%>'  <%=grade_code.equals(grade_list.get(i))?"selected":""%>><%= (String)grade_list.get(i+1)%> </option>
				<%
				}
				%>				
				</select>
				</td>			
			</tr>


			



			<tr><td colspan="2">&nbsp;</td></tr>
			
			<%if(eff_status.equalsIgnoreCase("E"))
				{%>
			<tr>
				<td width="35%"  class="label"><fmt:message key="Common.ExplanatoryText.label" bundle="${common_labels}"/></td>
				<td>
				<textarea name='position_expl_text' rows='10' cols='50' scrolling=auto maxlength='4000' onblur="checkfld(this)"><%=position_expl_text%></textarea>
				</td>
			<%}
				else
				{%>
					<td width="35%"  class="label"><fmt:message key="Common.ExplanatoryText.label" bundle="${common_labels}"/></td>
				<td>
				<textarea name='position_expl_text' rows='10' cols='50' readonly scrolling=auto maxlength='4000' onblur="checkfld(this)"><%=position_expl_text%></textarea>
				</td>
				<%}%>
			</tr>
			<tr><td colspan="2">&nbsp;</td></tr>
			
			<%if(eff_status.equalsIgnoreCase("E"))
			{
			%>
			<tr>
				
				<td width="35%"  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td ><input type=checkbox name="eff_status" id="eff_status" value="<%=eff_status%>" onclick="checkActive(this)" checked>
				</td></tr>
					

			<%
			}else{
			%>	
			<tr>
				<td  width="35%"  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td ><input type=checkbox name="eff_status" id="eff_status" value="<%=eff_status%>" 	onclick="checkActive(this)">
				 </td></tr>
					<tr>
                   <td class="label">&nbsp;</td>
                   <td class="label">&nbsp;</td>
                   </tr>	

			<%}%>
		<input type=hidden name='role_type_hidden' id='role_type_hidden' value='<%=role_type%>'>
		<input type=hidden name='staff_type_hidden' id='staff_type_hidden' value='<%=staff_type%>'>
		<input type=hidden name='grade_short_desc' id='grade_short_desc' value='<%=grade_short_desc%>'>
	<%	}%>
  <tr>
    <td class="label">&nbsp;</td>
    <td class="label">&nbsp;</td>
  </tr>	
	</table>

	<input type=hidden name='operation_type' id='operation_type' value='<%=operation_type%>'>
	<%}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{
		  if (rs != null)   rs.close();
		  if (pstmt != null) pstmt.close();
		  if (rs1 != null)   rs1.close();
		  if (stmt != null) stmt.close();
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
<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
%>

