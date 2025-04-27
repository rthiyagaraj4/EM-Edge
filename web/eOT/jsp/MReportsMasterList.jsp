<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	String locale = (String)session.getAttribute("LOCALE"); 
   request.setCharacterEncoding("UTF-8");
%>
<html>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/NoteTypeForSpecialities.js'></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language='javascript' src='../../eOT/js/MasterReports.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%

Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
//String mode=request.getParameter("mode");
String master_code_desc="";
String table_id="";
String sql = "";
%>
<form onload='FocusFirstElement()'  action="" method="" > 
<table border=0 cellspacing=0 cellpadding=3  width='100%'  align='center'>
 <tr>
<td width='25%'>&nbsp;</td>
<td width='25%'>&nbsp;</td>
<td width='25%'>&nbsp;</td>
<td width='25%'>&nbsp;</td>
</tr> 
<tr>
<td>&nbsp;</td>
	<td class='label' colspan='3'><fmt:message key="Common.code.label" bundle="${common_labels}"/>
	<select name="speciality_description" id="speciality_description" onChange="loadPage(this.value)" >
 	<option value='' selected><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
<% try
      {
        con=ConnectionManager.getConnection(request);
		String ot="OT";
		sql="select master_code_desc, table_id from sm_master_code where module_id ='"+ot+"' order by 1";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
		if(rs!=null)
		{
		   while(rs.next())
		        {
			        master_code_desc=rs.getString(1);
			        table_id=rs.getString(2);
                    %>	
					<option value= " <%=table_id%>"> <%=master_code_desc%> </option>
            <%  }
	  }%>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'>
		
	 <% }catch(Exception e){out.println("exp"+e);}

	  finally{
	try{
		
	 if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		ConnectionManager.returnConnection(con);
	}catch(Exception e)
		{
		out.println("exp"+e);
		}
}
%>

</td>

</tr>
 <tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr> 
<!-- <tr>
    <td align="right" class="label">
		<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callDetailForm();"  ></td>
	<td align="right" class="label">
		<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearvalues();"   ></td>
		
</tr> -->
</table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


