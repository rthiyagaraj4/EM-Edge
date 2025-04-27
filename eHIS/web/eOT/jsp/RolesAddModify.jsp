<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/Roles.js'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> <!--Modified Against GHL-SCF-1519-->
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
String role_id= request.getParameter("role_id")==null?"":request.getParameter( "role_id" );
String chk_checked="checked";
String chk_value="E";
String chk_checked1="checked";
String chk_value1="Y";
String disable_flag="";
String role_id_disable="";
String role_type="";
String role_desc="";
String role_type_desc = "";
String appl_to_ot_slate="";
String status="";
String sql="";
String sql1="";
String role_type1="";
String role_type_desc1="";
if(mode.equals("modify"))
{
	try{
		con=ConnectionManager.getConnection(request);
	//	sql="SELECT A.ROLE_ID,A.ROLE_DESC,A.ROLE_TYPE,B.ROLE_TYPE_DESC, nvl(A.APPL_TO_OT_SLATE,'N') appl_to_ot_slate, nvl(A.STATUS,'E') STATUS FROM OT_ROLES_LANG_VW A, OT_ROLE_TYPE B WHERE A.LANGUAGE_ID='"+locale+"' AND A.ROLE_TYPE = B.ROLE_TYPE(+) and ROLE_ID=? ";        
	
	  	sql="SELECT A.ROLE_ID,A.ROLE_DESC,A.ROLE_TYPE,B.ROLE_TYPE_DESC, nvl(A.APPL_TO_OT_SLATE,'N') appl_to_ot_slate, nvl(A.STATUS,'E') STATUS FROM OT_ROLES_LANG_VW A, OT_ROLE_TYPE_LANG_VW B WHERE A.LANGUAGE_ID= ? AND B.LANGUAGE_ID= ? AND A.ROLE_TYPE = B.ROLE_TYPE(+) and ROLE_ID=? "; 
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,locale);
		stmt.setString(3,role_id);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			role_id=rs.getString("role_id");
			role_desc=rs.getString("role_desc");
			role_type1=rs.getString("role_type");
			role_type_desc1=rs.getString("role_type_desc");
			appl_to_ot_slate=rs.getString("appl_to_ot_slate");
			status=rs.getString("status");
		}

		if(appl_to_ot_slate.equals("Y"))
			chk_checked1="checked";
		else
		{    chk_checked1="";
		    chk_value1="N";
		}
		if(status.equals("E"))
		{
			chk_checked="checked";
			disable_flag="";
			
		}
		else
		{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}
		
	role_id_disable="disabled";	
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
}

%>
<form name="roles_form" id="roles_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.RolesServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3  width='100%'  align=center>
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr>

<tr>
	<td class=label >
		<fmt:message key="eOT.RoleID.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="role_id" id="role_id" value="<%=role_id%>" size=20 maxlength=20  <%=role_id_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label >
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="role_desc" id="role_desc" value="<%=role_desc%>"  size=60 maxlength=60 <%=disable_flag%>>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>

    <%
	if(mode.equals("insert"))
	{%>
	<td class=label >
		<fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></td>
	<td class='fields'>
		<select name="role_type_desc" id="role_type_desc" >
	<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
	<%

	try{
			con=ConnectionManager.getConnection(request);

         //   sql1="SELECT ROLE_TYPE_DESC, ROLE_TYPE FROM OT_ROLE_TYPE ORDER BY 1";
		 
		   sql1="SELECT ROLE_TYPE_DESC, ROLE_TYPE FROM OT_ROLE_TYPE_LANG_VW WHERE LANGUAGE_ID= ? ORDER BY 1";

           stmt=con.prepareStatement(sql1);
		   stmt.setString(1,locale);
		   rs=stmt.executeQuery();
         
		   while (rs.next())
		{
			   role_type_desc=rs.getString("role_type_desc");
			   role_type=rs.getString("role_type");

			   %> <option value="<%=role_type%>"><%=role_type_desc%></option>
       <% }
 }catch(Exception e){e.printStackTrace();}
      finally{
	           try{
		             if(rs!=null) rs.close();
		             if(stmt!=null) stmt.close();
		             ConnectionManager.returnConnection(con,request);
	              }catch(Exception e)
		             {
						e.printStackTrace();
						//out.println("exp"+e);
		             }
            }
%>
</select>
<img src='../../eCommon/images/mandatory.gif'></td>
	<%} else if(mode.equals("modify"))
	{%>
	<td class=label >
		<fmt:message key="Common.RoleType.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<select name="role_type_desc" id="role_type_desc" <%=disable_flag%>>
	
	<option value=<%=role_type1%>><%=role_type_desc1%></option>
	<%
	try{
			con=ConnectionManager.getConnection(request);

          //  sql1="SELECT ROLE_TYPE_DESC, ROLE_TYPE FROM OT_ROLE_TYPE ORDER BY 1";
		   
		   sql1="SELECT ROLE_TYPE_DESC, ROLE_TYPE FROM OT_ROLE_TYPE_LANG_VW WHERE LANGUAGE_ID= ? ORDER BY 1";

           stmt=con.prepareStatement(sql1);
		   stmt.setString(1,locale);
		   rs=stmt.executeQuery();

		   while (rs.next())
		{
			   role_type_desc=rs.getString("role_type_desc");
			   role_type=rs.getString("role_type");
				  if(role_type.equals(role_type1) && role_type_desc.equals(role_type_desc1))
			{
					  
			}
			else{
           %> <option value=<%=role_type%>><%=role_type_desc%></option>
			<%	   
			 }}
 }catch(Exception e){e.printStackTrace();}
      finally{
	           try{
		             if(rs!=null) rs.close();
		             if(stmt!=null) stmt.close();
		             ConnectionManager.returnConnection(con,request);
	              }catch(Exception e)
		             {
						e.printStackTrace();
		                //out.println("exp"+e);
		             }
	}	}%>
        </select> 
	</td>
	</tr>
	<% 
	if(mode.equals("insert"))
	{%>
<tr>
	<td class=label>
		<fmt:message key="eOT.ApplicableForOTSlate.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="appl_to_ot_slate" id="appl_to_ot_slate"
		onClick="appl_for_ot_slate();" value="<%=chk_value1%>"  >
    </td>
</tr>
		<%} else if(mode.equals("modify"))
		{%>
<tr>
	<td class=label >
			<fmt:message key="eOT.ApplicableForOTSlate.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="appl_to_ot_slate" id="appl_to_ot_slate"
		onClick="appl_for_ot_slate();"  value="<%=chk_value1%>" <%=chk_checked1%> <%=disable_flag%> >
	</td>
	
</tr>
	<%}%>
<tr>
	<td class=label >
		<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="checkbox" name="status" id="status" onClick='setCheckValue();'  value='<%=chk_value%>' <%=chk_checked%> >
	</td>
</tr>
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr>
</table>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>
<input type=hidden name=role_id1 value="<%=role_id%>">
<input type=hidden name=role_desc1 value="<%=role_desc%>">
<input type=hidden name=role_type_desc1 value="<%=role_type1%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


