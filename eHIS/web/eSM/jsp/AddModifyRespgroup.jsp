<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
	<head>
	<%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eSM/js/Respgroup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function convert(obj)
			{
				document.forms[0].resp_group_id.value=obj.value.toUpperCase();
			}
		</script>
		<%
            request.setCharacterEncoding("UTF-8");
			Connection con=null;
			Statement stmt = null;
			PreparedStatement pstmt = null;
			try{
			con = ConnectionManager.getConnection(request);
			
			ResultSet rs =null;
			stmt	=	con.createStatement();
    		String resp_group_id="";
			String resp_group_name="";
			String eff_status="";

			String chk_val="checked";
			String readOnly="";
			String other_read_only="";
			String fn_val="insert";
			
			
			resp_group_id=request.getParameter("resp_group_id");
			if(resp_group_id!=null)
			{
				readOnly="readonly";
				fn_val="modify";
				//String sql="select * from sm_resp_grp where resp_group_id='"+resp_group_id+"'";
				//if(stmt!=null) stmt.close();
				//stmt	=	con.createStatement();
				//rs		=	stmt.executeQuery(sql);
				
				String sql="select * from sm_resp_grp where resp_group_id=?";
				pstmt   = con.prepareStatement(sql);
				pstmt.setString	(	1,	resp_group_id		);
				rs		 = pstmt.executeQuery();
				if(rs!=null)
				{
					if(rs.next())
					{
						resp_group_name=rs.getString("resp_group_name");
						eff_status=rs.getString("eff_status");
						
						if(eff_status.equals("D"))
						{
							other_read_only="readonly";
							chk_val="";
						}
					}
				}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(pstmt!=null)pstmt.close();
			}
			else
			{
				resp_group_id="";
			}

			

		%>
	</head>
	<body OnMouseDown='CodeArrest()';  onload='FocusFirstElement()';  onKeyDown = 'lockKey()'>
	<form name='Respgroup_Form' id='Respgroup_Form' method='post' action='../../servlet/eSM.RespgroupServlet' target='messageFrame' >
		<br><br><br><br><br><br><BR><BR><BR><BR><BR>
		<table border=0 cellspacing=0 cellpadding=0 width='70%' align=center>
			<tr>
				<td width='25%'>&nbsp;</td>
				<td width='25%'>&nbsp;</td>
				<td width='25%'>&nbsp;</td>
				<td width='25%'>&nbsp;</td>
			</tr>
			<tr>
				<td class=label width="25%"><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
				<td class='fields' width="25%"><input type=text name='resp_group_id' id='resp_group_id' size=4 maxlength=4 onKeyPress="return CheckForSpecChars(event)" onblur='convert(this)' value='<%=resp_group_id%>' <%=readOnly%>>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
				<td width='25%'></td>
				<td width='25%'></td>
			</tr>
			<tr>
				<td colspan=4 width="25%">&nbsp;</td><td width='25%'></td><td width='25%'></td>
				<td width='25%'></td>
			</tr>
			<tr>
				<td class=label width="25%"><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
				<td  class='fields' width="25%"><input type=text name='resp_group_name' id='resp_group_name' size=20 maxlength=30  onBlur="makeValidString(this)" 	value="<%=resp_group_name%>" <%=other_read_only%>>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
				<td width='25%'></td><td width='25%'></td>
			</tr>
			<tr>
				<td colspan=4>&nbsp;</td><td width='25%'></td><td width='25%'></td><td width='25%'></td>
			</tr>
			<tr>
				
				<td class=label  width='40%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/> </td>
				<td width='20%' class='fields'><input type=checkbox name='eff_status' id='eff_status' value='E' <%=chk_val%>   >&nbsp;</td>
				<td width='25%'>&nbsp;</td><td width='25%'></td><td width='25%'></td>
			</tr>
			<tr>
				<td colspan=4 width='25%'>&nbsp;</td><td width='25%'></td><td width='25%'></td><td width='25%'></td>
			</tr>
		</table>
		<input type='hidden' name='function_name' id='function_name' value="<%=fn_val%>">
		</form>
	</body>
</html>
<%
	
	}catch(Exception e){out.println(e);}
			finally {
				
	ConnectionManager.returnConnection(con,request);
}					
%>

