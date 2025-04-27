<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/StatusDescriptions.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<!--body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;parent.commontoolbarFrame.document.forms[0].reset.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<body onLoad="parent.commontoolbarFrame.document.forms[0].reset.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>  <!--Modified Against GHL-SCF-1519-->
<% 

Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
String role_type = request.getParameter("role_type")==null?"":request.getParameter( "role_type" );
String role_type_disable="";
String role_type_desc="";
String role_type_desc_sysdef="";


String sql="";

try{
	con=ConnectionManager.getConnection(request);
		// sql=" SELECT ROLE_TYPE, ROLE_TYPE_DESC_SYSDEF, ROLE_TYPE_DESC FROM OT_ROLE_TYPE where role_type=?  ";

		sql=" SELECT ROLE_TYPE, ROLE_TYPE_DESC_SYSDEF, ROLE_TYPE_DESC FROM OT_ROLE_TYPE_LANG_VW where role_type=? AND  LANGUAGE_ID= ?";


		stmt=con.prepareStatement(sql);
        stmt.setString(1,role_type);       
        stmt.setString(2,locale);       
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			role_type=rs.getString("role_type");
			role_type_desc_sysdef=rs.getString("role_type_desc_sysdef");
			role_type_desc=rs.getString("role_type_desc");
			
		}
		
		
		role_type_disable="disabled";
}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		
		}


%>
<form name="Role_form" id="Role_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.RoleTypesServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='80%'  align=center>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>

<tr>
	<td class=label width='25%'>
	<fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields">
	<input type="text" name="role_type" id="role_type" value="<%=role_type%>" size=20 maxlength=20  <%=role_type_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" ></td>
</tr>

<tr>
	<td class=label width='25%'>
	<fmt:message key="eOT.SystemDefinedDescription.Label" bundle="${ot_labels}"/></td>
	<td width='25%' class="fields">
	<input type="text" name="role_type_desc_sysdef" id="role_type_desc_sysdef" value="<%=role_type_desc_sysdef%>"  size=30 maxlength=30 disabled>
	</td>
</tr>
<tr>
	<td class=label width='25%'>
	<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields">
	<input type="text" name="role_type_desc" id="role_type_desc" value="<%=role_type_desc%>"   size=30 maxlength=30 >
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
   <tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
</table>
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name='role_type1' id='role_type1' value="<%=role_type%>">
<input type="hidden" name='role_type_desc_sysdef1' id='role_type_desc_sysdef1' value="<%=role_type_desc_sysdef%>">
<input type="hidden" name='role_type_desc1' id='role_type_desc1' value="<%=role_type_desc%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


