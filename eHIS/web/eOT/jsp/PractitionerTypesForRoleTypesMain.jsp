<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eOT/js/PractitionerTypesForRoleTypes.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%

Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
String role_type="";
String role_type_desc="";
String sql = "";
%>
<form name="PractitionerTypesForRoleTypes_Form" id="PractitionerTypesForRoleTypes_Form"  onload='parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;FocusFirstElement();'  action="" method="" > 
<table border=0 cellspacing=0 cellpadding=3 width='80%'  align=center>
<tr>
	<td class=label align=right><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></td>
	<td align=left>&nbsp;<select name="role_type" id="role_type" onchange='clearDtl_Frame();'> <option value='' selected><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
   
<% try
      {
        con=ConnectionManager.getConnection(request);
		
		// sql="SELECT ROLE_TYPE_DESC, ROLE_TYPE FROM OT_ROLE_TYPE ORDER BY 1 ";
		
		sql="SELECT ROLE_TYPE_DESC, ROLE_TYPE FROM OT_ROLE_TYPE_LANG_VW WHERE LANGUAGE_ID= ?  ORDER BY 1 ";

		stmt=con.prepareStatement(sql);	
		stmt.setString(1,locale);
		rs=stmt.executeQuery();
		if(rs!=null)
		{
		   while(rs.next())
		        {
			        role_type_desc=rs.getString(1);
			        role_type=rs.getString(2);
                    %>	
	               <option value="<%=role_type%>"><%=role_type_desc%>
            <%  }
	  }%>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'>
		
	 <% }catch(Exception e){e.printStackTrace();}

	  finally{
	try{
		
	 if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		ConnectionManager.returnConnection(con);
	}catch(Exception e)
		{
			e.printStackTrace();
			//out.println("exp"+e);
		}
}
%>

</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
    <td class="label">
		<input type="button" class="button" name="search" id="search" value="Search" onClick="callDetailForm();"  ></td>
	<td class="label">
		<input type="button" class="button" name="clear" id="clear" value="Clear" onClick="clearvalues();"   ></td>
</tr>
</table>
<!-- added by Yadav for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
<!-- end -->

<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


